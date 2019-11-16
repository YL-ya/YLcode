package com.bit.operation;

import com.bit.book.BookList;

public class Exit implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("byebye");
        System.exit(0);//程序正常结束
    }
}
