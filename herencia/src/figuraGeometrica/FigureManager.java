package figuraGeometrica;

class FigureManager {

	protected Figure[] figure = new Figure[0];
	
	FigureManager(Figure[] figure) {
		this.figure = figure;
	}
	
	Figure[] getFigure() {
		return figure;
	}

	void setFigure(Figure[] figure) {
		this.figure = figure;
	}
	
	@Override
	public String toString() {
		return "FigureManager [figure=" + figure.length + "]";
	}

	double totalPerimeter() {
		double total = 0;
		for(int i = 0 ; i<figure.length ; i++)
			if(figure[i].getSideNumber() == 1)
				total += ((Circle)figure[i]).perimeter();
			else if(figure[i].getSideNumber() == 3)
				total += ((Triangle)figure[i]).perimeter();
			else if(figure[i].getSideNumber() == 4)
				total += ((Square)figure[i]).perimeter();
		return total;
	}
	
}
