//以公告管理为例
//实体类

package Collection;

import java.util.Date;

public class Notice {
    private int id;
    private String name;
    private String creator;
    private Date createtime;

    public Notice(int id, String name, String creator, Date createtime) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String toString()
    {
        return "公告内容："+"\ni："+this.getId()+"   事件："+this.getName()+"   by"+this.getCreator()+"   时间"+this.getCreatetime();
    }
}

//测试类
package Collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeText {
    public static void main(String[] args) {
        Notice notice1=new Notice(1,"study","ann",new Date());
        Notice notice2=new Notice(2,"do homework","mary",new Date());
        Notice notice3=new Notice(3,"go to school","ed",new Date());
        Notice notice4=new Notice(4,"do houseowork","sun",new Date());

//向list中添加notice类元素
        List<Notice> noticeList=new ArrayList<>();
        noticeList.add(notice1);
        noticeList.add(notice2);
        noticeList.add(notice3);
        noticeList.add(notice4);

//        for(int i=0;i<noticeList.size();i++)
//        {
//            System.out.print(noticeList);//遍历输出列表内容
//        }

        for(int i=0;i<noticeList.size();i++)
        {
            //System.out.println(i+1+":"+((Notice)noticeList.get(i)).getName()+"   ");
            System.out.println(i+1+":"+noticeList.get(i).getName());
        }

        noticeList.remove(notice3);
        notice4.setName("学习学习");//更改notice4中内容
        noticeList.set(0,notice4);//将list中下标为0的元素设置为notice4


        for(int i=0;i<noticeList.size();i++)
        {
            System.out.println(i+1+":"+noticeList.get(i).getName());
        }

    }
}

/*
结果：
1:study
2:do homework
3:go to school
4:do houseowork

1:学习学习
2:do homework
3:学习学习

*/




