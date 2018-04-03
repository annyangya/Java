package Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CatSetText {
    public static void main(String[] args) {
        //定义宠物猫对象
        CatSet huahua=new CatSet("花花",12,"黄猫");
        CatSet fanfan=new CatSet("凡凡",4,"黑猫");
        //将宠物猫放入HashSet中
        Set<CatSet> set=new HashSet<CatSet>();
        set.add(huahua);
        set.add(fanfan);

        //显示宠物猫信息
        Iterator<CatSet> it=set.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        CatSet huahua2=new CatSet("花花",12,"黄猫");
        set.add(huahua2);
        //显示猫的信息
        System.out.println("添加重复数据之后：***************");
        it=set.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        CatSet huahua3=new CatSet("花花3",10,"白猫");
        set.add(huahua3);

        System.out.println("添加花花3数据之后：***************");
        it=set.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println("在集合中查找花花的信息并输出：***************");
        //使用对象名查找
        if(set.contains(huahua))
        {
            System.out.println("花花找到了");
            System.out.println(huahua);
        }else
        {
            System.out.println("花花没找到");
        }

        System.out.println("在集合中通过查找花花的名字来判断花花是否存在并输出：***************");
        boolean flag=false;//通过flag来判断花花是否找到，如果为true则找到，否则没有找到
        CatSet c=null;
        it=set.iterator();
        while(it.hasNext())
        {
            c=it.next();//注意这里要强制类型转换，因为next得到的是object对象
            if(c.getName().equals("花花"))
            {
                flag=true;//找到花花
                break;
            }
        }
        if(flag){
            System.out.println("huahua找到了");
            System.out.println(c);
        }else
        {
            System.out.println("huahua没有找到");
        }

        //通过增强行for循环遍历集合
//        //将集合set中的元素依次取出来放在cat中
//        for(CatSet cat:set)
//        {
//            if("花花3".equals(cat.getName()))
//            {
//                set.remove(cat);//此时花花3存放在cat中，所以删除cat即可
//                break;
//            }
//        }
//        //判断是否真的删除
//        System.out.println("删除花花3之后的数据：***************");
//        for(CatSet cat:set)
//        {
//            System.out.println(cat);
//        }


//        System.out.println("删除集合中所有元素***************");
//        boolean flag1=set.removeAll(set);//返回布尔值类型
//        if(flag1)//为真则删除成功
//        {
//            System.out.println("全部删除");
//        }else
//        {
//            System.out.println("没有全部删除");
//        }
//
//        if(set.isEmpty())
//        {
//            System.out.println("全部删除");
//        }else
//        {
//            System.out.println("没有全部删除");
//        }

        System.out.println("删除集合年龄大于等于10岁的猫***************");
        Set<CatSet> set1=new HashSet<CatSet>();
        for(CatSet cat:set)
        {
            if(cat.getMonth()>=10)
            {
                set1.add(cat);
            }
        }
        set.removeAll(set1);
        for(CatSet cat:set)
        {
            System.out.println(cat);
        }
    }
}
