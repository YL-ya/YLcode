package com.bit.operation;

import com.bit.book.BookList;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("ReturnOperation");
        System.out.println("输入需要删除书籍的名称");
    }
}
