/**
 * 结点类的描述
 * 
 * 单链表是由若干个结点连接而成，要实现单链表，首先需要设计结点类
 * 
 * 结点类由data和next组成
 * 
 * data是数据域，用来存放数据元素的值
 * next是指针域，用来存放后继结点的地址
 * 
 * @author acer
 *
 */
public class Node
{
    private Object data; //存放结点值
    
    private Node next; //后继结点的引用
    
    //无参数时的构造方法
    public Node()
    {
        this(null, null);
    }
    
    //带一个参数的构造方法
    public Node(Object data)
    {
        this(data, null);
    }
    
    //带两个参数的构造方法
    public Node(Object data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}