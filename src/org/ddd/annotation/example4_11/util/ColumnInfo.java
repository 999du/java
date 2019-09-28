package org.ddd.annotation.example4_11.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.ddd.annatation.example4_11.annotation.Column;
import org.ddd.annatation.example4_11.annotation.ID;

public class ColumnInfo {
	
	private String columnName; 
	private Class<?> type; 
	private boolean isID = false; 
	private boolean nullable = true;
	private int length = 32;
	private boolean needPersist = false; 
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public boolean isID() {
		return isID;
	}
	public void setID(boolean isID) {
		this.isID = isID;
	}
	public boolean isNullable() {
		return nullable;
	}
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public Class<?> getType() {
		return type;
	}
	public void setType(Class<?> type) {
		this.type = type;
	}
	public boolean isNeedPersist() {
		return needPersist;
	}
	public void setNeedPersist(boolean needPersist) {
		this.needPersist = needPersist;
	}
	
	
	public static ColumnInfo parse(Field field){
		ColumnInfo column = new ColumnInfo();
		column.columnName = field.getName();
		column.type = field.getType();
		Annotation[] annotations = field.getAnnotations();
		for(Annotation annotation : annotations){
			if(annotation.annotationType().equals(Column.class)){ 
				column.needPersist = true; 
				Column columnAnno = (Column)annotation; 
				if(!columnAnno.value().equals("")){ 
					column.columnName = columnAnno.value();
				}
				column.nullable = columnAnno.nullable();
				if(columnAnno.length() != -1){ //
					column.length = columnAnno.length();
				}
			}else if(annotation.annotationType().equals(ID.class)){
				column.needPersist = true;
				ID id = (ID)annotation;
				column.isID = true;
				if(!id.value().equals("")){ 
					column.columnName = id.value();
				}
			}
		}
		if(column.needPersist){
			return column;
		}else{
			return null;
		}
	}
	

	@Override
	public String toString(){
		StringBuilder sql = new StringBuilder(columnName);
		
		if(this.type.equals(String.class)){
			sql.append(Symbol.BLANK + "VARCHAR(" + this.length + ")");	
		}else if(this.type.equals(Integer.class)){
			sql.append(Symbol.BLANK + "INT");
		}
		
		if(this.isID){
			sql.append(Symbol.BLANK + "PRIMARY KEY");
		}
		if(!this.isNullable()){
			sql.append(Symbol.BLANK + "NOT NULL");
		}
		sql.append(";");
		return sql.toString();
	}	
}