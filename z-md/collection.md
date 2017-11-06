
### 数据结构

Array：线性表
    
    基于索引(index)的数据结构，使用索引搜索和读取数据很快，要删除数据开销很大，
    因为需要重排数组中的所有数据，更新索引。

Linked：链表

    相对于Array，Linked插入更快，不需要改变数据的大小，插入或删除时间复杂度仅为O(1)。
    Linked需要更多的内存，Array每个索引的位置是实际数据，Linked中每个节点存储的是
    实际的数据和前后节点的位置。

Hash：哈希表 hashCode()和equals()

Tree：树 compareTo()

Queue：队列


### 集合总结

Collection、
    List、
        ArrayList、Vector、
        LinkedList、
    Set、
        HashSet、hashCode()和equals()
        LinkedHashSet
        TreeSet、compareTo()
    SortedSet、
    Queue、
Map、
    Map、
        HashMap、Hashtable、hashCode()和equals()
        LinkedHashMap
        TreeMap、compareTo()
        WeakHashMap、
        IdentityHashMap、
    SortedMap、
    Map.Entry、
Iterator、
    Iterator、
        ListIterator、
    foreach、    
    Enumeration、


### Collection

- List 可重复

        public interface List<E> extends Collection<E>
    
    1、ArrayList
    
        public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, Serializable
    
        public abstract class AbstractList<E> extends AbstractCollection<E>
        implements List<E>
    
    2、挽救的子类：Vector
    
    3、ArrayList和Vector区别
    
        性能：        异步，性能更高     同步，性能较低
    
        线程安全：    非线程安全类       线程安全类
    
        输出：        Iterator,foreach  前两个+Enumeration
    
    4、LinkedList与Queue接口
     
        public class LinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Queue<E>, Cloneable, Serializable
    
    Queue，队列操作，FIFO(先进先出)
    
        public interface Queue<E> extends Collections<E>
 
- Set 不可重复，重复内容靠hashCode()和equals()方法区分

        public interface Set<E> extends Collection<E>
    
    Set接口没有对Collection接口扩充，要求更严格了，不能增加重复元素
    
    1、散列的存放：HashSet，散列存放，没有顺序
    
    2、有序的存放：TreeSet，有序排序
    
        public class TreeSet<E> extends AbstractSet<E>
        implements SortedSet<E>, Cloneable, Serializable
    
        public abstract class AbstractSet<E> extends AbstractCollection<E>
        implements Set<E>
    
    3、关于TreeSet的排序说明，要排序的对象要实现Comparable接口，覆写
    compareTo()方法
    
    4、关于HashSet重复元素的说明
    
        覆写Object类的equals()和hashCode()方法，一个完整的类最好覆写Object类的
        hashCode()、equals()、toString()三个方法。
        
- SortedSet 排序

        public interface SortedSet<E> extends Set<E>

- Queue 队列接口

     Queue，队列操作，FIFO(先进先出)
        
        public interface Queue<E> extends Collections<E>


### 集合输出方式

- Iterator：迭代输出，是使用最多的输出方式
        
        public interface Iterator<E>
    
    hashNext()
    
    next()
    
    remove()
    
- ListIterator：双向迭代输出，专门用于输出List中的内容

        public interface ListIterator<E> extends Iterator<E>
        
    双向输出时，完成由后向前必须先由前向后

- foreach：Java新支持
        
        for(类 对象：集合) {
            //集合操作
        }
    
    更建议使用Iterator完成集合输出
    
- Enumeration：废弃的接口

        public interface Enumeration<E>
        
    要想使用此接口，可以通过Vector类，elements()方法
    
    
### Map

- Map

        public interface Map<K,V>
        
        public Set<Map.Entry<K,V>> entrySet() 将Map对象变为Set结合
        
        public Set<K> keySet() 取得所有的key
        
        public Collection<V> values() 取得全部的value
        
    1、HashMap：无存存放，新操作类，key不允许重复
        
        public class HashMap<K,V> extends AbstractMap<K,V>
        implements Map<K,V>, Cloneable, Serializable
        
        public abstract class AbstractMap<K,V> extend Object
        implements Map<K,V>
        
    2、Hashtable：无存存放，旧操作类，key不允许重复
    
    3、HashMap与Hashtable区别
    
        性能        异步，性能更高     同步，性能较低
        
        线程安全    非线程安全         线程安全

    4、TreeMap：可排序的map集合，按key排序，key不允许重复
    
        自定义类作为key时，必须实现Comparable接口

    5、WeakHashMap：弱引用的map集合，当集合中的某些内容不再使用时清除掉无用
    的数据，使用gc回收。
        
        public class WeakHashMap<K,V> extends AbstractMap<K,V>
        implements Map<K,V>
        
        弱引用示例：
        map.put(new String("mldn"), new String("www.mldn.cn"));
        
        对象的引用强度说明：
        强引用：内存不足，JVM宁可出现OutOfMemeryError错误而使程序停止，也不会回收此对象来释放空间。
        软引用：内存不足，会回收这些对象的内存，用来实现内存敏感的高速缓存。
        弱引用：无论内存是否紧张，被垃圾回收器发现立即回收。
        虚引用：和没有任何引用一样。
    
    6、Map接口的使用注意事项
        
        1、不能直接使用迭代输出Map中的全部内容
        (1)entrySet()
        (2)Iterator
        (3)Map.Entry
        (4)key-->value
        Map集合在开发中基本作为查询应用较多，全部输出的操作较少，
        而Collection接口在开发中的主要作用就是传递内容及输出的。

    7、IdentityHashMap：key可以重复的map集合。
    
- SortedMap
    
        public interface SortedMap<K,V> extends Map<K,V>
        
        对象所在类必须实现Comparable接口
      
- Map.Entry
        
        public static interface Map.Entry<K,V>
        
        1、不能直接使用迭代输出Map中的全部内容
        (1)entrySet()
        (2)Iterator
        (3)Map.Entry
        (4)key-->value
        
### Collections

        public class Collections extends Object
        
    

        
        