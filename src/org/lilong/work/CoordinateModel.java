package org.lilong.work;

public class CoordinateModel {
	private String name;
	private int id;
	private int X;
	private int Y;
	private int Z;
	private int offsetX = Integer.MAX_VALUE;
	private int offsetY = Integer.MAX_VALUE;
	private int offsetZ = Integer.MAX_VALUE;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public int getZ() {
		return Z;
	}
	public void setZ(int z) {
		Z = z;
	}
	public int getOffsetX() {
		return offsetX;
	}
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	public int getOffsetY() {
		return offsetY;
	}
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	public int getOffsetZ() {
		return offsetZ;
	}
	public void setOffsetZ(int offsetZ) {
		this.offsetZ = offsetZ;
	}
	@Override
	public String toString() {
		return "CoordinateModel [name=" + name + ", id=" + id + ", X=" + X
				+ ", Y=" + Y + ", Z=" + Z + ", offsetX=" + offsetX
				+ ", offsetY=" + offsetY + ", offsetZ=" + offsetZ + "]";
	}
	
	
}
 