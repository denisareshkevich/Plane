package com.epam.oreshkevich.entity;

/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class PlaneWithOxyAngleView implements Observer {

    private Plane plane;
    private double angleWithOxy;
    private PlaneWithOxyAxeAngleModel planeOxyAxeModel ;

    public PlaneWithOxyAngleView(PlaneWithOxyAxeAngleModel planeOxyAxeModel) {
        this.planeOxyAxeModel = planeOxyAxeModel;
        planeOxyAxeModel.addObserver(this);

    }

    @Override
    public void update(double angleWithOxy) {
        this.angleWithOxy = angleWithOxy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaneWithOxyAngleView)) return false;

        PlaneWithOxyAngleView that = (PlaneWithOxyAngleView) o;

        if (Double.compare(that.angleWithOxy, angleWithOxy) != 0) return false;
        if (plane != null ? !plane.equals(that.plane) : that.plane != null) return false;
        return planeOxyAxeModel != null ? planeOxyAxeModel.equals(that.planeOxyAxeModel) : that.planeOxyAxeModel == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = plane != null ? plane.hashCode() : 0;
        temp = Double.doubleToLongBits(angleWithOxy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (planeOxyAxeModel != null ? planeOxyAxeModel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlaneWithOxyAngleView{" +
                "plane=" + plane +
                ", angleWithOxy=" + angleWithOxy +
                '}';
    }
}
