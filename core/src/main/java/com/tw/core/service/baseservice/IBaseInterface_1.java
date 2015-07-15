package com.tw.core.service.baseservice;

import java.util.List;

/**
 * Created by marry on 7/12/15.
 */
public interface IBaseInterface_1 {
//    public List<?> queryWhoseExtendClassOfPostMessageOrderByProperty(
//            String theTypeOfPostMessage, String userIdOfThePoster,
//            String property) throws Exception;

    public List<?> queryExtendClassOfPostMessageOrderByProperty(
            String theTypeOfPostMessage, String property) throws Exception;

   // public List<Dictionary> queryDictionary(String key);

//    public File createFile(String fileName);

//    public boolean isEngineer(Person person);

//    public boolean isCompany(Person person);

   // public HeadImage queryOnesHeadImage(String objectId);

  //  public <T> List<ObjectImage> getObjectImage(List<T> objectList, int flag);

//    public String getObjectId(Object object, int flag);
}
