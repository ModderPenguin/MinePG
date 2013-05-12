package rpg.core.transformers;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public interface ClassTransformer {

    public void transformMethod(ClassNode clazz, MethodNode method);

}