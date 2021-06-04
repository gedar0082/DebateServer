package com.debater.debaterserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "rights")
@ApiModel(value = "Rights", description = "rights table(that using in person_debate table)")
public class Rights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "read")
    @ApiModelProperty(value = "read")
    private Integer read;

    @Column(name = "write")
    @ApiModelProperty(value = "write")
    private Integer write;

    @Column(name = "creator")
    @ApiModelProperty(value = "creator")
    private Integer creator;

    public Rights(){}

    public Rights(Integer read, Integer write){
        this.read = read;
        this.write = write;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getRead() { return read; }

    public void setRead(Integer read) { this.read = read; }

    public Integer getWrite() { return write; }

    public void setWrite(Integer write) { this.write = write; }

    public Integer getCreator() { return creator; }

    public void setCreator(Integer creator) { this.creator = creator; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rights rights = (Rights) o;
        return Objects.equals(id, rights.id) &&
                Objects.equals(read, rights.read) &&
                Objects.equals(write, rights.write) &&
                Objects.equals(creator, rights.creator);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((read == null) ? 0 : read.hashCode());
        result = prime * result + ((write == null) ? 0 : write.hashCode());
        result = prime * result + ((creator == null) ? 0 : creator.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return "Rights[id = " + id +
                ", read = " + read +
                ", write = " + write +
                ", creator = " + creator + "];";
    }


}
