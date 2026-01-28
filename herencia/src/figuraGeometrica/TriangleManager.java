package figuraGeometrica;

class TriangleManager extends FigureManager{
	
	Triangle[] triangle = new Triangle[0];
	
	public TriangleManager(Figure[] figure) {
		super(figure);
		for(int i = 0 ; i<figure.length ; i++)
			if(figure[i].getSideNumber() == 3)
				addTriangle((Triangle)figure[i]);
	}

	double totalArea() {
		double total = 0;
		for(int i = 0 ; i<triangle.length ; i++)
			total += triangle[i].area(); 
		return total;
	}
	
	void addTriangle(Triangle t) {
		Triangle[] aux = triangle;
		triangle = new Triangle[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			triangle[i] = aux[i];
		triangle[aux.length] = t;
	}
	
}
