package org.ddd.annotation.example4_11.util;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.ddd.annotation.example4_11.annotation.Entity;

/**
 * 琛ㄤ俊鎭紝瀵瑰簲鏁版嵁搴撲腑鐨勪竴寮犺〃
 */
public class TableInfo {
	private String tableName;  //琛ㄧ殑鍚嶇О
	private Class<?> clazz; //璇ヨ〃瀵瑰簲鐨勫疄浣撶被鍨嬩俊鎭被
	private boolean needPersist = false; //鏄惁闇�瑕佹寔涔呭寲瀛樺偍
	private Map<String,ColumnInfo> columns = new HashMap<String,ColumnInfo>(); //璇ヨ〃涓殑鎵�鏈夊瓧娈典俊鎭�

	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	/**
	 * 鍚戝瓧娈靛垪琛ㄤ腑娣诲姞瀛楁淇℃伅
	 * @param key 瀛楁鐨勬爣璇嗭紝涓�鑸槸瀛楁鍚�
	 * @param column //瀛楁淇℃伅锛屽寘鎷悕绉般�佺被鍨嬨�侀檺鍒剁瓑
	 */	
	public void addColumn(String key,ColumnInfo column){
		this.columns.put(key, column);
	}
	public boolean isNeedPersist() {
		return needPersist;
	}
	public void setNeedPersist(boolean needPersist) {
		this.needPersist = needPersist;
	}
	
	/**
	 * 灏嗗疄浣撳搴旂殑绫诲瀷淇℃伅锛岃浆鎹㈡垚琛ㄤ俊鎭�
	 * 鍏惰浆鎹㈣繃绋嬪嚭濡備笅锛�
	 * 1.鏍规嵁绫诲瀷淇℃伅锛岃幏鍙栧疄浣撶被鐨勭畝鍗曞悕绉颁綔涓鸿〃鍚�
	 * 2.鑾峰彇鍦ㄨ绫讳笂浣跨敤鐨勬敞瑙ｉ泦鍚�
	 * 3.閬嶅巻杩欎簺闆嗗悎锛�
	 * 		1.濡傛灉鍙戠幇杩欎簺闆嗗悎涓惈鏈堾Entity娉ㄨВ锛屽垯琛ㄦ槑璇ュ疄浣撻渶瑕佹寔涔呭寲瀛樺偍锛岀劧鍚庤幏鍙朄Entity娉ㄨВ鐨勫弬鏁皏alue
	 * 			濡傛灉鍙傛暟涓嶄负绌猴紝鍒欏皢琛ㄦ槑璁句负姝ゅ弬鏁板�硷紝璺冲嚭寰幆
	 * 		2.濡傛灉娌℃湁鎵惧埌璇ユ敞瑙ｏ紝鍒欒鏄庢瀹炰綋涓嶉渶瑕佹寔涔呭寲瀛樺偍锛屽垯杩斿洖null
	 * 4.濡傛灉璇ュ疄浣撻渶瑕佹寔涔呭寲瀛樺偍锛屽垯閬嶅巻璇ュ疄浣撶被鍨嬩俊鎭殑鎵�鏈夊睘鎬ф弿杩板璞″垪琛ㄣ�傚苟灏嗗畠浠浆鎹㈡垚琛ㄧ殑瀛楁淇℃伅瀵硅薄锛屾坊鍔犲埌瀛楁淇℃伅map涓�
	 * 5.鏈�鍚庤繑鍥炶В鏋愬ソ鐨勮〃淇℃伅瀹炰綋
	 * @param clazz 瀹炰綋瀵瑰簲鐨勭被鍨嬩俊鎭�
	 * @return 鐢辩被鍨嬩俊鎭�岃浆鍖栨垚鐨勮〃淇℃伅瀵硅薄
	 */
	public static TableInfo parse(Class<?> clazz){
		TableInfo table = new TableInfo();
		table.clazz = clazz;
		table.tableName = table.clazz.getSimpleName();
		Annotation[] annotations = table.clazz.getAnnotations();
		for(Annotation annotation : annotations){
			if(annotation.annotationType().equals(Entity.class)){ //濡傛灉鍖呭惈@Entity娉ㄨВ锛屽垯琛ㄦ槑姝ゅ疄浣撻渶瑕佹寔涔呭寲瀛樺偍
				table.needPersist = true; //鎸佷箙鍖栧瓨鍌ㄦ爣蹇楋紝璁句负true
				Entity entity = (Entity)annotation;
				if(!entity.value().equals("")){
					table.tableName = entity.value();
				}
				break;
			}
		}
		if(table.needPersist){  //濡傛灉闇�瑕佹寔涔呭寲瀛樺偍锛岄亶鍘嗙敓鎴愬瓧娈典俊鎭�
			Field[] fields = table.clazz.getDeclaredFields();
			for(Field field : fields){
				ColumnInfo column = ColumnInfo.parse(field);
				if(column != null){
					table.columns.put(field.getName(), column);
				}
				
			}
			return table;
		}
		else //涓嶉渶瑕佹寔涔呭寲瀛樺偍锛屽垯杩斿洖null
		{
			return null;
		}
	}
	
	/**
	 * 浣跨敤琛ㄤ俊鎭璞＄敓鎴怱QL鍒涘缓璇彞
	 */
	@Override
	public String toString(){
		StringBuilder sql = new StringBuilder();
		sql.append(Symbol.LINE);
		sql.append("CREATE TABLE ");
		sql.append(this.tableName + Symbol.BLANK);
		sql.append("(");
		for(ColumnInfo column : this.columns.values()){
			sql.append(Symbol.LINE);
			sql.append(Symbol.TAB);
			sql.append(column.toString());
		}
		sql.append(Symbol.LINE);
		sql.append(");");
		return sql.toString();
	}
}
