package _00_Java;

public class DemoCollectionMapIterator {
	public static void main(String[] args) {
	}
}

/*
====================类集
	说明=类集是一组Java实现的数据结构,指的是动态对象数组;
		链表可以实现对象数组操作,但开发麻烦;链表操作性能差;链表使用Object对象保存,强制向下转型带来安全隐患;	所以开发链表使用难度很高;
		Java提供了与链表类似的工具类[Vector](向量),随着JDK发展类集现在包含以下几个核心接口=
			[Collection]、[List]、[Set];
			[Map];
			[Iterator]、[Enumeration];

====================[Collection]父接口=[java.util Interface Collection<E>]
	说明=[Collection]接口是整个类集之中"单值"保存的最大父接口;即=每次向集合中保存一个对象;
	方法=
 		*取得[Iterator]接口的实例化对象=[public Iterator<E> iterator()]
		*向集合中保存数据=[public boolean add(E e)]
		追加一个集合=public [boolean addAll(Collection<? extends E> c)]
		清空集合=[public void clear()];也就是根元素为"null";
		判断是否是空集合=[public boolean isEmpty()]
		判断是否包含指定对象=[public boolean contains(Object o)];此操作需要"equals()"支持;
		删除对象=[public boolean remove(Object o)];此操作需要"equals()"支持;
		取得集合中对象个数=[public int size()]
		将集合转换为对象数组=public [Object[] toArray()]
	总结=[Collection]接口存放数据的主要目的是为了输出数据;最常用的[iterator()]和[add()]方法,实际开发中很少直接使用[Collection]接口,几乎都使用它的两个子接口[List](80%)和[Set](20%);
==========[List]子接口(80%),此集合允许内容重复;父接口=[Collection];
	说明=[List]是[Collection]的子接口,且对父接口进行了方法的扩充;如想使用[List]接口,可使用它的子类[ArrayList](90%)和[Vector](10%);[List]接口中可以保存重复的元素;[List]接口中数据的保存顺序就是数据的添加顺序;
	方法=
		*取得指定索引编号的内容=[public E get(int index)];[Collection]接口无此方法
		修改指定索引编号的内容=[public E set(int index,E element)]
		取得[Iterator]接口的实例化对象=[public ListIterator<E> listIterator()]
=====[ArrayList]子类(90%)
	说明=[ArrayList]是[List]接口最常用的子类;
=====[Vector]子类(10%)
=====[ArrayList]和[Vector]的区别
	[ArrayList]=采用异步处理;非线程安全;输出支持[Iterator]、[ListIterator]、[foreach];
	[Vector]=采用同步处理;线程安全;输出支持[Iterator]、[ListIterator]、[foreach]、[Enumeration];
=====总结
	[List]接口中数据的保存顺序就是数据的添加顺序;可以保存重复的元素;比父接口[Collection]扩充了[get()]方法;使用子类实例化对象选择[ArrayList]子类;
==========[Set]子接口(20%),此集合不允许内容重复;父接口=[Collection];
	说明=[Set]是[Collection]的子接口,此子接口不像[List]子接口那样扩充有大量方法(如[get()]);[Set]集合没有重复元素;
=====[HashSet]子类(建议)
	说明=[HashSet]是无序排序;因实现了[Set]接口,没有重复数据;
=====[TreeSet]子类
	说明=[TreeSet]是有序排序,自动排序;因实现了[Set]接口,没有重复数据;
=====排序功能说明
	[TreeSet]是使用[Comparable]接口完成的比较,所以[TreeSet]子类种保存的元素需实现[Comparable]接口;
=====重复元素功能说明
	[Set]接口要实现判断重复元素需要使用[Object]类中的[hashCode()]和[equals()]方法;
		取得哈希码=[public int hashCode()];
			通过此方法判断对象的哈希码是否相同;
		对象比较=[public boolean equals(Object obj)];
			通过此方法将对象的属性进行依次比较是否都相同;
=====总结
	实际开发中建议不使用[Set]而使用[List]接口,如果使用,建议使用[Set]接口的[HashSet]子类,此子类可回避需使用[Comparable]接口问题;因为[Comparable]比较器主要是Java理论研究使用;[Set]接口数据不能重复;

====================集合输出
	说明=[Collection]、[List]、[Set]这三个接口中[List]接口是最方便进行输出操作的(因为有[get()]方法,可以取得指定索引内容);集合支持以下5种输出=
		[Iterator](95%)、[Enumeration](4.9%)、[ListIterator](0.05%)、[foreach](0.05%);
=====[Iterator]接口(95%)=迭代输出=[java.util Interface Iterator<E>]
	说明=
		[Iterator]本身是一个接口,要想取得本接口的实例化对象,只能通过[Collection]接口(它的子接口[List]和[Set]接口也一样)的[public Iterator<E> iterator()]方法取得;
	方法=
		判断是否有下一个元素=[public boolean hasNext()];
		取得当前元素=[public E next()];
=====[Enumeration]接口(4.5%),[public interface Enumeration<E>]
	说明=
		[Enumeration]本身是一个接口,要想取得此接口的实例化对象,只能通过[Vector]子类的[public Enumeration<E> elements()]方法;
	方法=
		判断是否有下一个元素=[public boolean hasMoreElements()];功能类似[Iterator]的[hasNext()];
		取得当前元素=[public E nextElement()];功能类似[Iterator]的[next()];
=====总结=集合的输出有4种形式,但几乎都以[Iterator]和[Enumeration]接口为主;

====================[Map]接口
	说明=[Map]接口可以保存一对对象(key=value)信息,且可以根据key查找value的功能,key不允许重复;([Collection]接口每次只能向集合中保存一个对象)
	方法=
		向集合中保存一对数据=[public V put(K key,V value)]
		根据key取得对应的value数据=[public V get(Object key)]
		将Map集合转化为Set集合=[public Set<Map.Entry<K,V>> entrySet()]
		取出全部的key=[public Set<K> keySet()]
	总结=[Map]存放数据的主要目的是为了以后的信息查找;建议使用String类型作为key的类型;[Map]接口中key数据不能重复,如有重复的key会进行覆盖,使用新的内容替换旧的内容;
==========[HashMap]子类(90%)
	说明=[HashMap]定义的[Map]集合中保存的数据是无序存放的;key数据不能重复,如有重复的key会进行覆盖,使用新的内容替换旧的内容;
==========[Hashtable]子类(10%)
	说明=[Hashtable]定义的[Map]集合中保存的数据key和value都不能为null;
==========[Map.Entry]内部接口=[public static interface Map.Entry<K,V>]
	说明=Map集合中的数据是以Map.Entry接口对象封装的;每当向[Map]集合使用[put()]方法保存一对数据时,实际上所有的数据都会被自动封装为[Map.Entry]接口(此为[类.类]的形式,说明是内部接口)对象;
	方法=此内部接口有如下方法
		取得key=[public K getKey()]
		取得value=[public V getValue()]
==========[Map]集合输出
	说明=[Map]集合不像[Collection]集合那样可以直接取得[Iterator]对象;
		需先使用[Map]集合中[public Set<Map.Entry<K,V>> entrySet()]方法将其转换为[Set]集合;(Map.Entry<K,V>详见如下)
	总结=[Map]集合使用[Iterator]接口输出的步骤=(例=见截图)
		1.使用[Map]接口中[entrySet()]方法将[Map]集合转换为[Set]集合;取得的[Set]集合泛型是"Set<Map.Entry<K,V>>";
		2.使用[Set]集合中的[iterator()]方法取得[Iterator]接口对象;然后使用[Iterator]将[Set]集合进行输出;
		3.其中[Iterator]每次循环取得都是[Map.Entry]接口对象,使用此对象的[getKey()]和[getValue()]方法进行key和value的输出;
==========补充(了解)
	[Map]集合中key的说明=如果将自定义的类对象作为key的话,那么此类需覆写[Object]类中的[hashCode()]和[equals()]方法,因为只有覆写这两个方法,才能确定一个元素是否重复;

====================[Stack]类(了解)
	说明=[Stack]表示栈操作,栈是一种先进后出的数据结构;主要用于Android手机开发上;[Stack]是[Vector]的子类,但并不会使用[Vector]类的方法;
	方法=	入栈=[public E push(E item)];	出栈=[public E pop()];

====================[Properties]子类(了解)
	说明-国际化程序=同一个程序,根据不同的语言环境选择不同的资源文件,资源文件后缀必须是"*.properties";
	说明=此类也是国际化程序的处理类,但主要还是以[ResourceBundle]类为主,此类了解即可;[java.util.Properties]类是[java.util.Hashtable<K,V>]的子类;
		此类主要进行属性的操作(属性特点=使用字符串设置key和value);
		此类不需设置泛型,因为它从一开始出现就只能保存String类型;
	方法=
		设置属性=[public Object setProperty(String key,String value)]
		取得属性=[public String getProperty(String key)];如果key不存在,返回null;
		取得属性=[public String getProperty(String key,String defaultValue)];如果key不存在,返回默认值;
		将设置好的属性信息输出到输出流=[public void store(OutputStream out,String comments) throws IOException]
		从输入流读取属性信息=[public void load(InputStream inStream) throws IOException]

====================[Collections]工具类(了解)=[java.util.Collections]=[public class Collections extends Object]
	说明=[Collections]是一个集合工具类,可以进行[List]、[Set]、[Map]集合操作;
	方法=
		为集合追加数据=[public static <T> boolean addAll(Collection<? super T> c,T... elements)]
		反转集合中的数据=[public static void reverse(List<?> list)]

====================[Stream]数据流=[java.util.stream Interface Stream<T>]
	说明=[java.util Interface Collection<E>]的[default Stream<E> stream()]方法可以取得[Stream]对象;
		[Stream]对象可以对集合数据进行加工处理(如=统计个数、消除重复、数据筛选过滤、),用于大数据处理;[Iterator]对象只可以对集合数据进行迭代输出;
	方法=
		取得集合数据个数=[long count()]
		消除集合中重复数据=[Stream<T> distinct()]
		收集器=[<R,A> R collect(Collector<? super T,A,R> collector)];此方法应在将数据都处理完之后使用;
			此方法的参数指[java.util.stream.Collectors]类的[public static <T> Collector<T,?,List<T>> toList()]方法的返回值;
		数据过滤=[Stream<T> filter(Predicate<? super T> predicate)];例=[filter((x) -> x.contains("a"))];
	方法=进行集合数据分页操作
		设置跳过指定的数据行数=[Stream<T> skip(long n)];例=[skip(2)];
		设置取出的数据个数=[Stream<T> limit(long maxSize)];例=[limit(2)];
	方法=进行集合数据的全匹配或部分匹配
		全匹配=[boolean allMatch(Predicate<? super T> predicate)]
		匹配任意一个=[boolean anyMatch(Predicate<? super T> predicate)]
			断言型函数接口[Predicate]的[default Predicate<T> or(Predicate<? super T> other)]方法,实现或操作;
			断言型函数接口[Predicate]的[default Predicate<T> and(Predicate<? super T> other)]方法,实现与操作;
	方法=进行集合数据统计分析=MapReduce
		对数据进行逐行处理=[<R> Stream<R> map(Function<? super T,? extends R> mapper)];例=[map((x) -> x.toLowerCase())];
		数据分析=[<U> U reduce(U identity,BiFunction<U,? super T,U> accumulator,BinaryOperator<U> combiner)]
			[java.util.function Interface BiFunction<T,U,R>];T和U是参数,R是返回值类型;
	方法=了解,因为需要使用Lamda表达式,虽然简化了代码量,但是实现难度较高;
		按照Double处理=[DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)]
		按照Float处理=[LongStream mapToLong(ToLongFunction<? super T> mapper)]
		按照Int处理=[IntStream mapToInt(ToIntFunction<? super T> mapper)]
=====总结
	类集中很多地方都需使用Lamda表达式,自JDK1.8开始,类集中提供的接口出现了很多default或static修饰的方法;
	JDK 1.8中之所以增加"default"权限的方法,是因为需要扩充接口的功能,如果要扩充的是普通方法时,该接口的所有子类都必须重复实现这个方法,这样使用子类太麻烦了,才使用了"default";
	核心=MapReduce=	Map=处理数据;	Reduce=对数据统计分析;

====================问题
=====[ArrayList]和[Vector]的区别?
	[ArrayList]=采用异步处理;非线程安全;输出支持[Iterator]、[ListIterator]、[foreach];
	[Vector]=采用同步处理;线程安全;输出支持[Iterator]、[ListIterator]、[foreach]、[Enumeration];

=====[HashMap]和[Hashtable]的区别?
	[HashMap]=采用异步处理;非线程安全;输出支持[Iterator]、[ListIterator]、[foreach];设置数据key或value允许为null;
	[Hashtable]=采用同步处理;线程安全;输出支持[Iterator]、[ListIterator]、[foreach]、[Enumeration];设置数据key或value都不能为null;

=====[Collection]和[Collections]的区别?
	[Collection]是集合操作的接口;
	[Collections]是集合操作的工具类,可以进行[List]、[Set]、[Map]集合操作;
*/