package com.example.testpproject.zyhs.lsn_11;

import org.junit.Test;

import static com.example.testpproject.zyhs.lsn_11.Graph.MAX_WEIGHT;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void test(){
//        Graph graph=new Graph(5);
//        int[] a0=new int[]{0,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,6};
//        int[] a1=new int[]{9,0,3,MAX_WEIGHT,MAX_WEIGHT};
//        int[] a2=new int[]{2,MAX_WEIGHT,0,5,MAX_WEIGHT};
//        int[] a3=new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0,1};
//        int[] a4=new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};
//        graph.matrix[0]=a0;
//        graph.matrix[1]=a1;
//        graph.matrix[2]=a2;
//        graph.matrix[3]=a3;
//        graph.matrix[4]=a4;
//        System.out.println(graph.getInDegree(2));
//        System.out.println(graph.getOutDegree(2));

        Graph graph = new Graph(5);
        int[] v0 = new int[]{0, 1, 1, MAX_WEIGHT, MAX_WEIGHT};
        int[] v1 = new int[]{MAX_WEIGHT, 0, MAX_WEIGHT, 1, MAX_WEIGHT};
        int[] v2 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT, MAX_WEIGHT};
        int[] v3 = new int[]{1, MAX_WEIGHT, MAX_WEIGHT, 0, MAX_WEIGHT};
        int[] v4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 1, MAX_WEIGHT, 0};
        graph.matrix[0] = v0;
        graph.matrix[1] = v1;
        graph.matrix[2] = v2;
        graph.matrix[3] = v3;
        graph.matrix[4] = v4;
        graph.dfs();
//        graph.bfs();

    }
}









