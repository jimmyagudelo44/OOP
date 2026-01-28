package figuraGeometrica;

class SquareManager extends FigureManager{

	Square[] square = new Square[0];
	
	SquareManager(Figure[] figure) {
		super(figure);
		for(int i = 0 ; i<figure.length ; i++)
			if(figure[i].getSideNumber() == 4)
				addSquare((Square)figure[i]);
	}

	double totalArea() {
		double total = 0;
		for(int i = 0 ; i<figure.length ; i++)
			if(figure[i].getSideNumber() == 4)
				total += ((Square)figure[i]).area();
		return total;
	}
	
	void addSquare(Square s) {
		Square[] aux = square;
		square = new Square[aux.length+1];
		for(int i = 0 ; i<aux
				.length ; i++)
			square[i] = aux[i];
		square[aux.length] = s;
	}
	
}
