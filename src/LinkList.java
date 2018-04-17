import java.util.Scanner;

/**
 * 单链表类的描述
 * 
 * 由于单链表只需一个头指针就能唯一的标示它，所以单链表类的成员变量只需设置一个头指针即可
 * 
 * @author acer
 * 
 */
public class LinkList implements IList
{
    //单链表的头指针
    private Node head;

    public LinkList()
    {
        //初始化头结点
        head = new Node();
    }

    public LinkList(int n, boolean Order) throws Exception
    {
        this();
        if (Order)
        {
            create1(n);
        } else
        {
            create2(n);
        }
    }

    // 用尾插法顺序建立单链表，其中n为单链表的结点个数
    public  void create1(int n) throws Exception
    {
        //构造用于输入对象
        Scanner sc = new Scanner(System.in);
        
        for(int j = 0; j < n; j++)
        {
            //生成新结点，插入到表尾
            insert(length(), sc.next());
        }
    }

    // 用头插法逆位序建立单链表，其中n为单链表的结点个数
    public void create2(int n) throws Exception
    {
        /*
         * 构造用于输入对象
         * 
         * Scanner 使用分隔符模式将其输入分解为标记，默认情况下该分隔符模式与空白匹配
         * 然后可以使用不同的 next 方法将得到的标记转换为不同类型的值。
         */
        Scanner sc = new Scanner(System.in);

        for (int j = 0; j < n; j++)
        {
            //生成新结点，插入到表头
            insert(0, sc.next());
        }
    }

    // 将一个已经存在的带头结点单链表置为空表
    @Override
    public void clear()
    {
        head.setData(null);
        
        head.setNext(null);
    }

    // 判断带头结点的单链表是否为空
    @Override
    public boolean isEmpty()
    {
        return head.getNext() == null;
    }

    // 求带头结点的单链表的长度
    @Override
    public int length()
    {
        Node p = head.getNext();
        
        int lenth = 0;
        
        while(p != null)
        {
            p = p.getNext();
            
            ++lenth;
        }
        
        return lenth;
    }

    /*
     * 读取带头结点的单链表中的第i个结点
     * 
     * 时间复杂度为O(n)
     */
    @Override
    public Object get(int i) throws Exception
    {
        // 初始化，p指向首结点，j为计数器
        Node p = head.getNext();

        int j = 0;

        // 从首结点开始向后查找，直到p指向第i个结点或p为空
        while (p != null && j < i)
        {
            // 指向后继结点
            p = p.getNext();

            // 极速器加1
            ++j;
        }

        // i小于0或者大于表长减1
        if (j > i || p == null)
        {
            // 抛出异常
            throw new Exception("第" + i + "个元素不存在");
        }

        // 返回结点p的数据域的值
        return p.getData();
    }

    /*
     * 在带头结点的单链表中的第i个结点之前插入一个值为x的新结点
     * 
     * 时间复杂度为O(n)
     */
    @Override
    public void insert(int i, Object x) throws Exception
    {
        // 初始化，p指向首结点，j为计数器
        Node p = head;

        int j = -1;

        // 寻找第i个结点的前驱
        while (p != null && j < i - 1)
        {
            p = p.getNext();

            // 计数器加1
            ++j;
        }

        // i不合法
        if (j > i - 1 || p == null)
        {
            // 抛出异常
            throw new Exception("插入位置不合法");
        }

        // 生成新结点
        Node s = new Node(x);

        // 修改链，使新结点插入到单链表中
        s.setNext(p.getNext());

        p.setNext(s);
    }

    /*
     * 在不带头结点的单链表的第i个结点之前插入一个数据域值为x的新结点
     * 
     * 时间复杂度为O(n)
     */
    public void insert2(int i, Object x) throws Exception
    {
        // 初始化，p指向首结点，j为计数器
        Node p = head;

        int j = 0;

        // 用i = -1\0\1测试
        while (p != null && j < i - 1)
        {
            p = p.getNext();

            ++j;
        }

        if (j > i || p == null)
        {
            throw new Exception("插入位置不合法");
        }

        Node s = new Node(x);

        // 插入位置为表头时
        if (i == 0)
        {
            s.setNext(head);

            head = s;
        }
        // 插入位置为表的中间或表尾时
        else
        {
            s.setNext(p.getNext());

            p.setNext(s);
        }
    }

    /*
     * 删除单链表中的第i个结点
     * 
     * 时间复杂度为O(n)
     */
    @Override
    public void remove(int i) throws Exception
    {
        // 初始化，p指向首结点，j为计数器
        Node p = head;

        int j = -1;

        // 寻找第i个结点的前驱
        while (p.getNext() != null && j < i - 1)
        {
            p = p.getNext();

            ++j;
        }
        if (j > i - 1 || p.getNext() == null)
        {
            throw new Exception("删除位置不合法");
        }

        // 修改链指针，使待删除结点从单链表中脱离
        p.setNext(p.getNext().getNext());

    }

    /*
     * 在单链表中查找值为x的结点
     * 
     * 时间复杂度为O(n)
     */
    @Override
    public int indexOf(Object x)
    {
        // 初始化，p指向首结点，j为计数器
        Node p = head.getNext();

        int j = 0;

        // 下面从单链表中的首结点开始查找，直到p.getData()为x或到达单链表的表尾
        while (p != null && !p.getData().equals(x))
        {
            // 指向下一个结点
            p = p.getNext();

            // 计数器加1
            ++j;
        }

        // 若p指向单链表中的某个结点，返回值为x的结点在单链表中的位置
        if (p != null)
        {
            return j;
        } else
        {
            // 值为x的结点不在链表中
            return -1;
        }
    }

    // 输出单链表中的所有结点
    @Override
    public void display()
    {
        //取出带头结点的单链表中的首结点
        Node p = head.getNext();
        
        while(p != null)
        {
            //输出结点的值
            System.out.print(p.getData() + " ");
            
            //取下一个结点
            p = p.getNext();
        }
        
        //换行
        System.out.println();
    }

}