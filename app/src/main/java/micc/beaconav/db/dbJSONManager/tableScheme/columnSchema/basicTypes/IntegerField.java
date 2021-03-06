package micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.basicTypes;

import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.ColumnField;
import micc.beaconav.db.dbJSONManager.tableScheme.columnSchema.ColumnSchema;

/**
 * Created by nagash on 01/02/15.
 */
public class IntegerField extends ColumnField<Integer> {

    public IntegerField(ColumnSchema<Integer> schema) {
        super(schema);
    }

    @Override
    protected Integer generateNewInitValue() {
        return new Integer(0);
    }

    @Override
    protected Integer parseString(String newStringToParse) {
        return Integer.parseInt(newStringToParse);
    }

    @Override
    public Integer generateDeepCopy(Integer copy) {
        return new Integer(copy);
    }
}
