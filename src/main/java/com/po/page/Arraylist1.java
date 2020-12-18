package com.po.page;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;

public class Arraylist1 {
    public  void main() {
        ArrayList<String[]> arrayList = new ArrayList();
        String[] a = {"1", "2", "3"};
        String[] b = {"4", "5", "6"};
        String[] c = {"7", "8", "9"};
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        String[][] test = (String[][]) arrayList.toArray(new String[0][0]);
//toarray使用注意事项 可以在网上搜一下

//测试
        for (int i = 0; i < test.length; i++) {
              for (int j = 0; j < test[i].length; j++) {
                System.out.println(test[i][j]);
            }
        }

    }
}
