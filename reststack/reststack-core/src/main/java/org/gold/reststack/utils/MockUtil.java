package org.gold.reststack.utils;

import org.gold.reststack.utils.beannote.BeanNoteAdapter;
import org.gold.reststack.utils.beannote.BeanNoteHandler;
import org.gold.reststack.utils.beannote.DefaultBeanNoteHandler;
import org.gold.reststack.utils.mock.MockHandlerFactory;

/**
 * 实体mock数据工具
 * Created by wangar on 2016.3.23.
 */
public class MockUtil {

    private static BeanNoteHandler beanNoteHandler = new DefaultBeanNoteHandler();
    /**
     * mock数据
     * @param clazz 目标类
     * @param <T> 类型
     * @return 返回mock的实体数据
     */
    public static <T> T mock(Class<T> clazz){
        return MockHandlerFactory.getMockHandler(clazz).mock(clazz);
    }

    /***
     * 获取实体描述
     * @param clazz
     * @return
     */
    public static String beanNote(Class<?> clazz){
        return beanNoteHandler.noteHandler(BeanNoteAdapter.readNodes(clazz));
    }

}
