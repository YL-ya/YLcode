package com.bit.operation;
import com.bit.book.Book;
import com.bit.book.BookList;
public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("DelOperation");
        System.out.println("输入需要删除书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if(bookList.getBook(i).name.equals(name)) {
                break;
            }
        }
        if(i >= bookList.getSize()) {
            System.out.println("没有此书");
            return;
        }
        //2、开始删除
        int pos = i;
        for (int j = pos; j < bookList.getSize()-1; j++) {
            Book nextBook = bookList.getBook(j+1);
            bookList.setBooks(j,nextBook);
        }
        bookList.setSize(bookList.getSize()-1);
        System.out.println("删除成功！");
    }
}
