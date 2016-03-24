package org.gold.reststack.utils.beannote;

import org.gold.reststack.utils.JavaTypeUtil;
import org.gold.reststack.utils.mock.MockHandler;
import org.gold.reststack.utils.mock.MockHandlerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangwr on 2016.3.24.
 */
public class BeanNoteAdapter {

    public static List<Node> readNodes(Class<?> clazz){
        return readNodes(clazz,1);
    }

    private static List<Node> readNodes(Class<?> clazz,int index){
        List<Node> nodes = new ArrayList<Node>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            Node node = new Node();
            node.setIndex(index);
            node.setNodeKey(field.getName());
            Note note = field.getAnnotation(Note.class);
            node.setNodeNote(note==null?"-":note.value());
            Class<?> fc = (Class<?>) field.getGenericType();
            if(!JavaTypeUtil.isNormal(fc)){//递归
                node.setSubNodes(readNodes(field.getType(),index++));
            }
            nodes.add(node);
        }
        return nodes;
    }

}
