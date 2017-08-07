package org.doukang.springtest.aop;

public class ForumServiceImpl implements ForumService
{
    public void removeTopic(int topicId)
    {
        System.out.println("删除Topic记录：" + topicId);
        try
        {
            Thread.currentThread().sleep(10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void removeForum(int forumId)
    {
        System.out.println("删除Forum记录：" + forumId);
        try
        {
            Thread.currentThread().sleep(20);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
