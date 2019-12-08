package Nick_Maven.CleanCode.Planes;

import Nick_Maven.CleanCode.models.ClassificationLevel;
import Nick_Maven.CleanCode.models.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private ExperimentalTypes experimentalPlaneType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes experimentalPlaneType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalPlaneType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "modelPlane='" + modelPlane + '\'' +
                '}';
    }
}
