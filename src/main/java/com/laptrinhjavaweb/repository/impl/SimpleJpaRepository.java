package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.ForeignKey;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.JpaRepository;

public class SimpleJpaRepository<T> implements JpaRepository<T> {

	private Class<T> zClass;
	private String tableName;
	
	@SuppressWarnings("unchecked")
	public SimpleJpaRepository() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		if (zClass.isAnnotationPresent(Entity.class) && zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			this.tableName = table.name();
		}
	}

	@Override
	public List<T> findAll(String sqlSearch, Pageable pageable) {
		StringBuilder sql = new StringBuilder(sqlSearch);

		if (pageable != null && pageable.getLimit() != null && pageable.getOffset() != null) {
			sql.append(" limit " + pageable.getOffset() + ", " + pageable.getLimit());
		}
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			statement = connection.prepareStatement(sql.toString());
			resultSet = statement.executeQuery();

			return resultSetMapper.mapRow(resultSet, zClass);
		} catch (SQLException e) {
			return new ArrayList<T>();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return new ArrayList<T>();
			}
		}
	}
	
	
	
	@Override
	public List<T> findAll(Map<String, Object> params, Object... where) {
		StringBuilder sql = new StringBuilder("select * from " + this.tableName + " A where 1=1 ");

		sql = createSqlFindAll(params, sql);

		if (where != null && where.length > 0) {
			sql.append(where[0]);
		}

		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			statement = connection.prepareStatement(sql.toString());
			resultSet = statement.executeQuery();

			return resultSetMapper.mapRow(resultSet, zClass);
		} catch (SQLException e) {
			return new ArrayList<T>();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return new ArrayList<T>();
			}
		}
	}

	@Override
	public List<T> findAll(Map<String, Object> params, Pageable pageable, Object... where) {
		StringBuilder sql = new StringBuilder("select * from " + this.tableName + " A where 1=1 ");

		sql = createSqlFindAll(params, sql);

		if (where != null && where.length > 0) {
			sql.append(where[0]);
		}

		if (pageable != null && pageable.getLimit() > 0 && pageable.getOffset() > 0) {
			sql.append(" limit " + pageable.getOffset() + ", " + pageable.getLimit());
		}

		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			statement = connection.prepareStatement(sql.toString());
			resultSet = statement.executeQuery();

			return resultSetMapper.mapRow(resultSet, zClass);
		} catch (SQLException e) {
			return new ArrayList<T>();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return new ArrayList<T>();
			}
		}
	}

	@Override
	public T findById(Long id) {
		StringBuilder sql = new StringBuilder("select * from " + this.tableName + " A where A.id = ?");

		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			statement = connection.prepareStatement(sql.toString());
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			return resultSetMapper.mapRow(resultSet, zClass).get(0);
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	@Override
	public Long insert(T entity) {
		String sql = "";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = -1L;
		try {
			sql = createSqlInsert(entity);
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(statement, entity);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return id;
			}
		}
		return id;
	}

	
	
	@Override
	public Long insert(T entity,List<Object> entities) {
		String sql = "";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = -1L;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			sql = createSqlInsert(entity);
			
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(statement, entity);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			if(entities != null) {
				for(Object item : entities) {
					Field[] fields = item.getClass().getDeclaredFields();
					Class<?> parentClass = item.getClass().getSuperclass();
					while(parentClass != null) {
						fields = ArrayUtils.addAll(fields, parentClass.getDeclaredFields());
						parentClass = parentClass.getSuperclass();
					}
					for (Field field : fields) {
						if(field.isAnnotationPresent(Column.class)) {
							if(field.isAnnotationPresent(ForeignKey.class)) {
								ForeignKey foreignKey = field.getAnnotation(ForeignKey.class);
								Table tableName = entity.getClass().getAnnotation(Table.class);
								field.setAccessible(true);
								if(foreignKey.tableName().equals(tableName.name())) {
									field.set(item, id);
								}
							}
						}
					}
					sql = createSqlInsert(item);
					statement = connection.prepareStatement(sql);
					setParameters(statement, item);
					statement.executeUpdate();
				}
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return id;
			}
		}
		return id;
	}

	private void setParameters(PreparedStatement statement, Object entity)
			throws IllegalArgumentException, IllegalAccessException, SQLException {
		Field[] fields = entity.getClass().getDeclaredFields();
		Class<?> parentClass = entity.getClass().getSuperclass();
		while(parentClass != null) {
			fields = ArrayUtils.addAll(fields, parentClass.getDeclaredFields());
			parentClass = parentClass.getSuperclass();
		}
		int index = 1;
		for (Field field : fields) {
			field.setAccessible(true);
			if(field.get(entity) != null) {
				statement.setObject(index, field.get(entity));
				index++;
			}
		}
	}

	private String createSqlInsert(Object entity) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = entity.getClass().getDeclaredFields();
		Class<?> parentClass = entity.getClass().getSuperclass();
		while(parentClass != null) {
			fields = ArrayUtils.addAll(fields, parentClass.getDeclaredFields());
			parentClass = parentClass.getSuperclass();
		}
		String tableName = "";
		if (entity.getClass().isAnnotationPresent(Entity.class) && entity.getClass().isAnnotationPresent(Table.class)) {
			Table table = entity.getClass().getAnnotation(Table.class);
			tableName = table.name();
		}
		
		StringBuilder sqlParams = new StringBuilder("");
		StringBuilder sqlFields = new StringBuilder("");
		for (Field field : fields) {
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				field.setAccessible(true);
				if(field.get(entity) != null) {
					if (sqlFields.length() > 1) {
						sqlFields.append(",");
						sqlParams.append(",");
					}
					sqlFields.append(column.name());
					sqlParams.append("?");
				}

			}
		}
		String sql = "INSERT INTO "+ tableName +"("+sqlFields.toString()+") VALUES (" +sqlParams.toString()+")";
		return sql;
	}

	protected StringBuilder createSqlFindAll(Map<String, Object> params, StringBuilder sqlSearch) {
		if (params != null && params.size() > 0) {
			for (Map.Entry<String, Object> item : params.entrySet()) {
				String key = item.getKey();
				Object value = item.getValue();
				if (value != null && StringUtils.isNotBlank(value.toString())) {
					if (NumberUtils.isNumber(value.toString())) {
						sqlSearch.append(" AND A." + key.toLowerCase() + " = " + value + " ");
					} else {
						sqlSearch.append(
								" AND LOWER(A." + key.toLowerCase() + ") like LOWER('%" + value.toString() + "%') ");
					}
				}
			}
		}
		return sqlSearch;
	}

}
