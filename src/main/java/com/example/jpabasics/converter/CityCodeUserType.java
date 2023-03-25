package com.example.jpabasics.converter;

import com.example.jpabasics.model.CityCode;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CityCodeUserType implements UserType<CityCode> {
    @Override
    public int getSqlType() {
        return new Integer(Types.INTEGER);
    }

    @Override
    public Class<CityCode> returnedClass() {
        return CityCode.class;
    }

    @Override
    public boolean equals(CityCode cityCode, CityCode j1) {
        return cityCode==j1;
    }

    @Override
    public int hashCode(CityCode cityCode) {
        return cityCode !=null ?cityCode.hashCode() : 0;
    }

    @Override
    public CityCode nullSafeGet(ResultSet resultSet, int i, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws SQLException {
        Integer value = resultSet.getInt(1);
        if(value==7) return CityCode.ANTALYA;
        else if (value==35) return CityCode.İZMİR;
        else if (value==34) return CityCode.İSTANBUL;
        else if (value==6) return CityCode.ANKARA;
        else return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, CityCode cityCode, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        if(cityCode == null)
            preparedStatement.setObject(0,null);
        else
            preparedStatement.setInt(i,cityCode.getValue());
    }

    @Override
    public CityCode deepCopy(CityCode cityCode) {
        return cityCode;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(CityCode cityCode) {
        return cityCode;
    }

    @Override
    public CityCode assemble(Serializable serializable, Object o) {
        return (CityCode) serializable;
    }

    @Override
    public CityCode replace(CityCode cityCode, CityCode j1, Object o) {
        return cityCode;
    }
}
