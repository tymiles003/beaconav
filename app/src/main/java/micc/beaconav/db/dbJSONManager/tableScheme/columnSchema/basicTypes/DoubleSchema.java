package micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.basicTypes;

import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.ColumnField;
import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.ColumnSchema;

/**
 * Created by nagash on 02/02/15.
 */
public class DoubleSchema extends ColumnSchema<Double> {


    public DoubleSchema(String name) {
        super(name);
    }

    @Override
    public DoubleField newField() {
        return new DoubleField(this);
    }

}
