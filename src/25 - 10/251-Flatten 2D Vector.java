public class Vector2D {
	List<List<Integer>> vec2d;
	int x, y;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        int i = 0;
        while(i < vec2d.size() && vec2d.get(i).size() == 0) i++;
        this.x = i; this.y = 0;
    }

    public int next() {
        int next = vec2d.get(x).get(y);
        if(y < vec2d.get(x).size() - 1){
        	y++;
        }
        else{
        	x++;
        	while(x < vec2d.size() && vec2d.get(x).size() == 0) x++;
        	if(x < vec2d.size()) y = 0;
        }
        	
        return next;
    }

    public boolean hasNext() {
        return x <= vec2d.size() - 1 ? y < vec2d.get(x).size() : false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */