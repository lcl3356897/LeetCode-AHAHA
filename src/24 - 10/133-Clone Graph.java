//BFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        
        hm.put(node, head);
        q.add(node);
        while(!q.isEmpty()){
        	UndirectedGraphNode cur = q.poll();
        	for(UndirectedGraphNode neighbor : cur.neighbors){
        		if(!hm.containsKey(neighbor)){
        			q.add(neighbor);
        			UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
        			hm.put(neighbor, newNeighbor);
        		}

            	hm.get(cur).neighbors.add(hm.get(neighbor));
        	}
        }

        return head;
    }
}

//DFS
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
            
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        
        DFS(hm, node);//DFS
        return head;
    }

    private void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node){
    	if(node == null) return;

    	for(UndirectedGraphNode neighbor : node.neighbors){
    		if(!hm.containsKey(neighbor)){
    			UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
    			hm.put(neighbor, newNeighbor);
    			DFS(hm, neighbor);
    		}
    		hm.get(node).neighbors.add(hm.get(neighbor));
    	}
    }
}