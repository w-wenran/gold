package org.gold.reststack.utils.beannote;

import java.util.List;

/**
 * Created by wangwr on 2016.3.24.
 */
public class DefaultBeanNoteHandler implements BeanNoteHandler {

    @Override
    public String noteHandler(List<Node> nodes) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        for(Node node:nodes){
            stringBuffer.append(String.format("\"%s\":\"%s\"",node.getNodeKey(),node.getNodeValue()));
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
