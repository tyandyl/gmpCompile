package com.gmp.core;

import java.util.Date;
import java.util.List;

/**
 * Created by tianye13 on 2017/6/29.
 */
public interface Lexer {
    public static final int BASE_WORD=1;//基本字
    public static final int TAG=2;//标识符
    public static final int CONSTANT=3;//常数
    public static final int OPERATOR=4;//运算符
    public static final int DELIMITER=5;//定界符

    public List<String> parseTokens(String str, long tid)throws Exception;

    public boolean isAlphabetic(char c);

    public boolean isDigit(char c);

    public boolean isTimeOut(Date date);
}
