package rpg.core.transformers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import rpg.MinePGUtil;
import cpw.mods.fml.relauncher.IClassTransformer;

public class MobSpawnerTransformer implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (transformedName.equals("net.minecraft.block.BlockMobSpawner")) {

            System.out.println("transforming blockMobSpawner");
            ClassReader reader = new ClassReader(bytes);
            ClassNode clazz = new ClassNode(Opcodes.ASM4);

            reader.accept(clazz, 0);

            Type playerType = Type.getType(EntityPlayer.class);
            Type worldType = Type.getType(World.class);
            Type superType = Type.getType(clazz.superName);

            String desc = Type.getMethodDescriptor(Type.BOOLEAN_TYPE,
                    worldType, playerType, Type.INT_TYPE, Type.INT_TYPE,
                    Type.INT_TYPE);

            MethodNode method = new MethodNode(Opcodes.ACC_PUBLIC,
                    "removeBlockByPlayer", desc, null, null);

            InsnList code = method.instructions;

            code.add(new VarInsnNode(Opcodes.ALOAD, 0)); // load
                                                         // this
            code.add(new VarInsnNode(Opcodes.ALOAD, 1)); // world
            code.add(new VarInsnNode(Opcodes.ALOAD, 2)); // player
            code.add(new VarInsnNode(Opcodes.ILOAD, 3)); // x
            code.add(new VarInsnNode(Opcodes.ILOAD, 4)); // y
            code.add(new VarInsnNode(Opcodes.ILOAD, 5)); // z

            code.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, superType
                    .getInternalName(), "removeBlockByPlayer", desc)); // call
                                                                       // the
                                                                       // super
            LabelNode jumpTarget = new LabelNode();
            code.add(new JumpInsnNode(Opcodes.IFEQ, jumpTarget)); // jump
                                                                  // to
                                                                  // return
                                                                  // if
                                                                  // it
                                                                  // returned
                                                                  // false

            code.add(new VarInsnNode(Opcodes.ALOAD, 2)); // player
            code.add(new VarInsnNode(Opcodes.ALOAD, 1)); // world
            code.add(new VarInsnNode(Opcodes.ILOAD, 3)); // x
            code.add(new VarInsnNode(Opcodes.ILOAD, 4)); // y
            code.add(new VarInsnNode(Opcodes.ILOAD, 5)); // z

            code.add(new MethodInsnNode(Opcodes.INVOKESTATIC,
                    MinePGUtil.EVENT_HANDLER, "onMobSpawnerBreak", Type
                            .getMethodDescriptor(Type.VOID_TYPE, playerType,
                                    worldType, Type.INT_TYPE, Type.INT_TYPE,
                                    Type.INT_TYPE)));

            code.add(new InsnNode(Opcodes.ICONST_1)); // return
                                                      // true
            code.add(new InsnNode(Opcodes.IRETURN));

            code.add(jumpTarget);
            code.add(new InsnNode(Opcodes.ICONST_0)); // return
                                                      // false
            code.add(new InsnNode(Opcodes.IRETURN));

            clazz.methods.add(method);

            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES
                    | ClassWriter.COMPUTE_MAXS);
            clazz.accept(writer);
            bytes = writer.toByteArray();

        }
        return bytes;
    }
}