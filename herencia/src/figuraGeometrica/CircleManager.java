package figuraGeometrica;

class CircleManager extends FigureManager{

	Circle[] circle = new Circle[0];
	
	CircleManager(Figure[] figure) {
		super(figure);
		for(int i = 0 ; i<figure.length ; i++)
			if(figure[i].getSideNumber() == 1)
				addCircle((Circle)figure[i]);
	}
	
	void addCircle(Circle c) {
		Circle[] aux = circle;
		circle = new Circle[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			circle[i] = aux[i];
		circle[aux.length] = c;
	}
	
}
