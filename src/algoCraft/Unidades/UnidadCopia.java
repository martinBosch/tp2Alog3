package Unidades;
@SuppressWarnings("rawtypes")
public class UnidadCopia extends UnidadProtoss {
	Class claseDeLaUnidad;
	public UnidadCopia(int x, int y,Class claseDeLaUnidadACopiar,int escudoMaxUnidadACopiar,int escudoActualUnidadACopiar) {
		super(x, y);
		vida=0;
		danioA=0;
		danioT=0;
		claseDeLaUnidad=claseDeLaUnidadACopiar;
		escudoMax=escudoMaxUnidadACopiar;
		escudo=escudoActualUnidadACopiar;
	}
	public Class getClassCopia(){
		return claseDeLaUnidad;
	}
}
