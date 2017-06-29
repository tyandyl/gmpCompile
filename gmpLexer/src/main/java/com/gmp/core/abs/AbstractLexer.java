package com.gmp.core.abs;

import com.gmp.core.inter.Lexer;
import com.gmp.core.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tianye13 on 2017/6/29.
 */
public abstract class AbstractLexer implements Lexer {

    public List<String> parseTokens(String str, long tid) throws Exception{
        List<String> tokens=new ArrayList<String>();
        String curStr=str;
        Date date = DateUtils.addMilliSecond(new Date(),100);
        while (StringUtils.isNotBlank(curStr)){
            String token=null;
            for(int i=0;i< curStr.length();i++){
                boolean timeOut = DateUtils.isTimeOut(date);
                if(timeOut){
                    throw new Exception("timeOut error,tid:"+tid);
                }
                char c = curStr.charAt(i);
                if(isDigit(c) || isAlphabetic(c)){
                    continue;
                }
                if(i!=0){
                    token=curStr.substring(0,i);
                    tokens.add(token);
                    System.out.println("token:"+token);
                    curStr=curStr.substring(i);
                    break;
                }
                switch (c){
                    case '=':
                        break;
                    case '+':
                        break;
                    case '-':
                        break;
                    case '*':
                        break;
                    case '/':
                        break;
                    case ' ':
                        break;
                    default:
                        throw new Exception("tokenType error,tid:"+tid);
                }
                tokens.add(c+"");
                System.out.println("token:"+c);
                curStr=curStr.substring(i+1);
                break;
            }
        }
        return tokens;
    }


    public boolean isAlphabetic(char c) {
        boolean alphabetic = Character.isAlphabetic(c);
        return alphabetic;
    }

    public boolean isDigit(char c) {
        boolean digit = Character.isDigit(c);
        return digit;
    }

    public boolean isTimeOut(Date date) {
        boolean timeOut = DateUtils.isTimeOut(date);
        return timeOut;
    }

}