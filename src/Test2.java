import java.lang.reflect.Field;

/**
 * FileName: Test2
 * Author:   yangqinkuan
 * Date:     2019-12-4 8:18
 * Description:
 */

public class Test2 {
    private static Field[] getFields(String[] properties, String beanName){
        Field[] target = new Field[properties.length];
        try {
            Class<?> clz = Class.forName(beanName);
            Field[] origin=clz.getFields();

            for(int i=0;i<properties.length;i++){
                for(int j=0;j<origin.length;j++){
                    if(properties[i].equals(origin[j].getName())){
                        target[i] = origin[j];
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return target;
    }
    public static void main(String[] args) {
        String[] properties = {"operatorName","stopChargeReason"};

        Field[] result = getFields(properties,"ChargeOrderExt");
        for (Field field: result) {
            System.out.println(field.getName());
        }
    }
}
