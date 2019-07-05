package BianryTree_Graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 课表安排 ，有向无权图
 * @author qyl
 *
 */
public class Solution210
{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphNode[] gn = new GraphNode[numCourses];
        for(int i=0;i<numCourses;i++) {
        	gn[i] = new GraphNode(i);
        }
        for(int i=0;i<prerequisites.length;i++) {
        	int a = prerequisites[i][1];
        	int b = prerequisites[i][0];
        	
        	gn[a].list.add(b);     	
        	gn[b].inDegree++;
        }
        
        Deque<Integer> deque = new LinkedList<Integer>();
        for(GraphNode gn0:gn) {
        	if(gn0.inDegree==0)
        		deque.add(gn0.val);
        }
        int counter = 0;
        while(!deque.isEmpty()) {
        	int val = deque.pop();
        	counter+=1;
        	
        	for(int num:gn[val].list) {
        		gn[num].inDegree--;
        		//若入度为零，则加入
        		if(gn[num].inDegree==0)
        			deque.add(num);
        	}
        }
        if(counter==numCourses)
        	return true;
        return  false;
    }
    class GraphNode{
    	int val;
    	List<Integer> list;
    	int inDegree;
    	public GraphNode(int val) {
    		this.val=val;
    		this.inDegree=0;
    		this.list =new ArrayList<Integer>();
    	}
    }

}
