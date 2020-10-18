package com.example.testpproject.designmode.visitormode;


//定义一个表示访问者的接口。
public interface ComputerPartVisitor {

    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}
