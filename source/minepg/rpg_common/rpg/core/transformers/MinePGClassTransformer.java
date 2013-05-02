package rpg.core.transformers;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

import java.util.Map;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import com.google.common.collect.ImmutableMap;

import cpw.mods.fml.relauncher.IClassTransformer;

public class MinePGClassTransformer implements IClassTransformer {

	private static final Map<String, ClassTransformer> visitors;

	static {
		ImmutableMap.Builder<String, ClassTransformer> builder = ImmutableMap.builder();

		builder.put("net.minecraft.entity.monster.EntityZombie", new ZombieTransformer());

		visitors = builder.build();
	}

	@Override
	public byte[] transform(String name, String transformedName, byte[] bytes) {
		if (visitors.containsKey(transformedName)) {
			ClassReader reader = new ClassReader(bytes);
			ClassTransformer transformer = visitors.get(transformedName);

			ClassNode clazz = new ClassNode(Opcodes.ASM4);
			reader.accept(clazz, 0);

			for (MethodNode method : clazz.methods) {
				transformer.transformMethod(clazz, method);
			}

			ClassWriter writer = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
			clazz.accept(writer);
			bytes = writer.toByteArray();
		}
		return bytes;
	}

}