package com.lingye.leetcode;

public class ZigZag {

    /**
     * 总结规律：
     * 第一行和最后一行，每行两个数的下标之间相差的的间隔是2n-2
     * 中间的行数，看规律：
     * 该行的下一个待补充的列为奇数列，则这个奇数列下标间隔为该行下面已填充的数字个数，即2*(总行数-1-当前行数)
     * 若为偶数列，则是上面行所有的数字个数，即2*i
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows){

        //初始化返回数组
        String result=new String();
        // 第一行和最后一行两个之间的间隔
        int lengthGroup= 2 * numRows -2;
        //特殊情况直接返回
        if(numRows<=1||s.length()==0){
            return s;
        }
        for(int row=0;row<numRows;row++){
            //第一行和最后一行中的每一行两数之间相隔2n-2
            if(row==0 || row==numRows-1){
                // 遍历字符串，填充当前行，间距为lengthGroup
                for(int currRow=row;currRow<s.length();currRow+=lengthGroup){
                    result+=s.charAt(currRow);
                }
            }else{//中间行特殊处理
                //中间行中，前一个下标的值和后一个下标的值需要根据这个下标是该行中的奇数列还是偶数列来计算。以平时的习惯来计算，因此，行和列的开始值都是0。
                int currRow=row;
                // 默认开始从奇数列开始
                boolean oddFlg=true;
                //奇数列的间距
                int oddLengthGroup=2*(numRows-1-row);
                //偶数列的间距
                int evenLengthGroup=2*currRow;
                // 一行一行的填充，填充完一行再去填充下一行
                while(currRow<s.length()){
                    // 每行第一个即是之前字符串中的第几个
                    result+=s.charAt(currRow);
                    // 第一列默认是0即偶数列，那么下一个数必然在奇数列
                    if(oddFlg){
                        //currRow现在就相当于下标
                        currRow+=oddLengthGroup;
                    }else {
                        currRow+=evenLengthGroup;
                    }
                    oddFlg=!oddFlg;
                }

            }
        }

        return result;
    }
    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        ZigZag zigZag=new ZigZag();
        String k=zigZag.convert(s,3);
    }
}
