package com.dsr.Utils;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.omg.CORBA.INITIALIZE;


public class ExcelHelper {

    private List<String> fieldNames = new ArrayList<String>();
    private Workbook workbook = null;
    private String workbookName = "";

    public List<String> getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(List<String> fieldNames) {
        this.fieldNames = fieldNames;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public String getWorkbookName() {
        return workbookName;
    }

    public void setWorkbookName(String workbookName) {
        this.workbookName = workbookName;
    }

    public ExcelHelper(String workbookName) {

        this.workbookName = workbookName;
        initialize();
    }

    private void initialize() {
        // TODO Auto-generated method stub
        setWorkbook(new HSSFWorkbook());
    }

    public void closeWorksheet() {

        FileOutputStream fileOut;
        try {

            fileOut = new FileOutputStream(getWorkbookName());
            getWorkbook().write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private boolean setupFieldsForClass(Class<?> clazz) throws Exception {

        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fieldNames.add(fields[i].getName());
        }
        return true;
    }

    private void initializedForRead() throws InvalidFormatException, IOException {
        InputStream inp = new FileInputStream(getWorkbookName());
        workbook = WorkbookFactory.create(inp);
    }

    private Sheet getSheetWithName(String name) {
        Sheet sheet = null;
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            if (name.compareTo(workbook.getSheetName(i)) == 0) {
                sheet = workbook.getSheetAt(i);
                break;
            }
        }

        return sheet;
    }

    private Class<?> getGetterReturnClass(Class<?> clazz, String fieldName) {
        String MethodName = "get" + capitalize(fieldName);
        String MethodIsName = "is" + capitalize(fieldName);

        Class<?> returnType = null;
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(MethodName) || method.getName().equals(MethodIsName)) {
                returnType = method.getReturnType();
                break;
            }
        }
        return returnType;
    }

    private Method constructMethod(Class clazz, String fieldName) throws SecurityException, NoSuchMethodException {
        Class<?> fieldClass = getGetterReturnClass(clazz, fieldName);
        return clazz.getMethod("set" + capitalize(fieldName), fieldClass);
    }


    public String capitalize(String string) {
        String capital = string.substring(0, 1).toUpperCase();
        return capital + string.substring(1);
    }


    @SuppressWarnings({"unchecked","rawtypes"})
    public <T> List<T> readData(String Classname) throws Exception {
        initializedForRead();
        Sheet sheet = getSheetWithName(Classname);
        Class clazz = Class.forName(workbook.getSheetName(0));
        setupFieldsForClass(clazz);

        List<T> result = new ArrayList<T>();

        Row row;
        for (int rowCount = 1; rowCount < 4; rowCount++) {
            T one = (T) clazz.newInstance();
            row = sheet.getRow(rowCount);
            int colCount = 0;

            result.add(one);
            for (Cell cell : row) {
                CellType type = cell.getCellType();
                String fieldName = fieldNames.get(colCount++);
                Method method = constructMethod(clazz, fieldName);

                if (type == CellType.STRING) {
                    String value = cell.getStringCellValue();
                    Object[] values = new Object[1];
                    values[0] = value;

                    method.invoke(one, values);

                } else if (type == CellType.NUMERIC) {
                    Double num = cell.getNumericCellValue();
                    Class<?> returnType = getGetterReturnClass(clazz, fieldName);

                    if (returnType == int.class || returnType == Integer.class) {
                        method.invoke(one, num.intValue());
                    } else if (returnType == double.class || returnType == Double.class) {
                        method.invoke(one, num);
                    } else if (returnType == float.class || returnType == Float.class) {
                        method.invoke(one, num.floatValue());
                    } else if (returnType == long.class || returnType == Long.class) {
                        method.invoke(one, num.longValue());
                    } else if (returnType == Date.class) {
                        Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                        method.invoke(one, date);
                    }
                } else if (type == CellType.BOOLEAN) {
                    boolean num = cell.getBooleanCellValue();
                    Object[] values = new Object[1];

                    values[0] = num;
                    method.invoke(one, values);
                }
            }
        }
        return result;
    }

}
