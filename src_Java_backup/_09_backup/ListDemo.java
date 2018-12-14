package _09_backup;

import java.util.Collection;

public class ListDemo implements Collection<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
设置了泛型,从而保证集合中所有数据类型都一致;
java.util Interface List<E>
方法=
public E get(int index); 取得指定索引编号的内容;
public E set(int index,E element);修改指定索引编号的内容;
public ListIterator<E> listIterator();为ListIterator接口实例化;

实现类=
ArratList<E>;
Vector<E>;


*/