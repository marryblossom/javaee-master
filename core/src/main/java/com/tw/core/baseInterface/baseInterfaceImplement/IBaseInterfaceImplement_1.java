package com.tw.core.baseInterface.baseInterfaceImplement;

import com.tw.core.baseInterface.IBaseInterface_1;
import com.tw.core.bean.Person;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by marry on 7/12/15.
 */
public class IBaseInterfaceImplement_1 extends IBaseInterfaceImplement implements IBaseInterface_1 {
    private DetachedCriteria dCriteria;
    protected static final int USER = 0;
    protected static final int TEAM = 1;
    protected static final int USER_TEAM_TEAM = 2;
    protected static final int USER_TEAM_USER = 3;
    protected static final int DISCUSS = 4;
    protected static final int COMMENT = 5;

//    @SuppressWarnings({ "null" })
//    @Override
//    public List<?> queryWhoseExtendClassOfPostMessageOrderByProperty(
//            String theTypeOfPostMessage, String userIdOfThePoster,
//            String property) throws Exception {
//        Class<?> clazz = Class.forName(theTypeOfPostMessage);
//
//        dCriteria = DetachedCriteria.forClass(PostMessage.class);
//        dCriteria.add(Restrictions.eq("posterId", userIdOfThePoster));
//        List<PostMessage> postMessages = queryAllOfCondition(PostMessage.class,
//                dCriteria);
//        dCriteria = DetachedCriteria.forClass(Class
//                .forName(theTypeOfPostMessage));
//        dCriteria.addOrder(Order.desc(property));
//        List<?> classCompared = queryAllOfCondition(
//                Class.forName(theTypeOfPostMessage), dCriteria);
//
//        if (clazz.equals(Demand.class)) {
//            List<Demand> queryList = null;
//            for (int i = 0; i < classCompared.size(); i++) {
//                for (int j = 0; j < postMessages.size(); j++) {
//                    if (postMessages.get(j).equals(
//                            ((Demand) classCompared.get(i)).getPostMessage())) {
//                        queryList.add((Demand) classCompared.get(i));
//                    }
//                }
//            }
//            return queryList;
//        } else if (clazz.equals(Design.class)) {
//            List<Design> queryList = null;
//            for (int i = 0; i < classCompared.size(); i++) {
//                for (int j = 0; j < postMessages.size(); j++) {
//                    if (postMessages.get(j).equals(
//                            ((Design) classCompared.get(i)).getPostMessage())) {
//                        queryList.add((Design) classCompared.get(i));
//                    }
//                }
//            }
//            return queryList;
//        } else if (clazz.equals(News.class)) {
//            List<News> queryList = null;
//            for (int i = 0; i < classCompared.size(); i++) {
//                for (int j = 0; j < postMessages.size(); j++) {
//                    if (postMessages.get(j).equals(
//                            ((News) classCompared.get(i)).getPostMessage())) {
//                        queryList.add((News) classCompared.get(i));
//                    }
//                }
//            }
//            return queryList;
//        } else {
//            List<Question> queryList = null;
//            for (int i = 0; i < classCompared.size(); i++) {
//                for (int j = 0; j < postMessages.size(); j++) {
//                    if (postMessages.get(j).equals(
//                            ((Question) classCompared.get(i)).getPostMessage())) {
//                        queryList.add((Question) classCompared.get(i));
//                    }
//                }
//            }
//            return queryList;
//        }
//
//    }

//    @Override
//    public List<Dictionary> queryDictionary(String key) {
//        dCriteria = DetachedCriteria.forClass(Dictionary.class);
//        dCriteria.add(Restrictions.eq("dictionaryKey", key));
//        List<Dictionary> dictionary = queryAllOfCondition(Dictionary.class,
//                dCriteria);
//        return dictionary;
//    }

    @Override
    public List<?> queryExtendClassOfPostMessageOrderByProperty(
            String theTypeOfPostMessage, String property) throws Exception {
        Class<?> clazz = Class.forName(theTypeOfPostMessage);

        dCriteria = DetachedCriteria.forClass(clazz);
        dCriteria.addOrder(Order.desc(property));
        List<?> ExtendClasses = queryAllOfCondition(clazz, dCriteria);
        return ExtendClasses;
    }

//    @Override
//    public File createFile(String fileName) {//FileName类似一个properies
//        // TODO Auto-generated method stub
//        File dir = new File(FileName.ADDRESS);
//        if (!dir.exists()) {
//            dir.mkdir();
//        }
//        File file = new File(FileName.ADDRESS + "//" + fileName);
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return file;
//    }

//    @Override
//    public boolean isEngineer(Person person) {
//        boolean isEngineer = false;
//        if (person.getUserType().equals("engineer"))
//            isEngineer = true;
//        return isEngineer;
//    }

//    @Override
//    public boolean isCompany(User user) {
//        boolean isCompany = false;
//        if (user.getUserType().equals("company"))
//            isCompany = true;
//        return isCompany;
//    }

//    @Override
//    public HeadImage queryOnesHeadImage(String objectId) {
//        dCriteria = DetachedCriteria.forClass(HeadImage.class);
//        dCriteria.add(Restrictions.eq("objectId", objectId));
//        HeadImage headImage = new HeadImage();
//        if (queryAllOfCondition(HeadImage.class, dCriteria).size() > 0) {
//            headImage = queryAllOfCondition(HeadImage.class, dCriteria).get(0);
//        } else {
//            headImage = null;
//        }
//
//        return headImage;
//    }

//    @Override
//    public <T> List<ObjectImage> getObjectImage(List<T> objectList, int flag) {
//        // TODO Auto-generated method stub
//        List<ObjectImage> objectImages = new ArrayList<ObjectImage>();
//        DetachedCriteria criteria = DetachedCriteria.forClass(HeadImage.class);
//        List<HeadImage> headImages = queryAllOfCondition(HeadImage.class,
//                criteria);
//        for (T object : objectList) {
//            ObjectImage objectImage = new ObjectImage();
//            for (HeadImage headImage : headImages) {
//                if (headImage.getObjectId().equals(getObjectId(object, flag))) {
//                    objectImage.setHeadImage(headImage);
//                    objectImage.setObject(object);
//                    objectImages.add(objectImage);
//                    break;
//                }
//            }
//            if (objectImage.getObject() == null) {
//                objectImage.setHeadImage(null);
//                objectImage.setObject(object);
//                objectImages.add(objectImage);
//            }
//        }
//        return objectImages;
//    }

    /**
     * @param object
     *            –Ë“™∑µªÿIDµƒ∂‘œÛ
     * @param flag
     *            ∂‘œÛµƒ±Í æ
     * @return »Ùflag=USER£¨∑µªÿ”√ªß∂‘œÛµƒID£ª »Ùflag=TEAM£¨∑µªÿ–°◊È∂‘œÛµƒID£ª
     *         »Ùflag=USER_TEAM_TEAM£¨∑µªÿ”√ªß–°◊È∂‘œÛ÷––°◊ÈµƒID£ª
     *         »Ùflag=USER_TEAM_USER£¨∑µªÿ”√ªß–°◊È∂‘œÛ÷–”√ªßµƒID£ª »Ùflag=DISCUSS£¨∑µªÿÃ÷¬€∂‘œÛ÷–”√ªßµƒID£ª
     *         »Ùflag=COMMENT£¨∑µªÿ∆¿¬€∂‘œÛ÷–”√ªßµƒID£ª ∆‰À˚∑µªÿø’°£
     */
//    @Override
//    public String getObjectId(Object object, int flag) {
//        // TODO Auto-generated method stub
//        String objectId = null;
//        switch (flag) {
//            case USER:
//                objectId = ((User) object).getUserId();
//                break;
//            case TEAM:
//                objectId = ((Team) object).getTeamId();
//                break;
//            case USER_TEAM_TEAM:
//                objectId = ((UserTeam) object).getTeam().getTeamId();
//                break;
//            case USER_TEAM_USER:
//                objectId = ((UserTeam) object).getUser().getUserId();
//                break;
//            case DISCUSS:
//                objectId = ((Discuss) object).getUser().getUserId();
//                break;
//            case COMMENT:
//                objectId = ((Comment) object).getUser().getUserId();
//                break;
//            default:
//                break;
//        }
//        return objectId;
//    }
}

