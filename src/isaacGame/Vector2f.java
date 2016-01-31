package isaacGame;
/*
 File Name: Vector2f.java
 Student Name: Raymond Zhao
 Class: ICS4U
 Date: May 26, 2015
 Description: Holds two float values.
 */
public class Vector2f {
    //the fields
    private float x, y;
    
    //constructors
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    //copy constructor
    public Vector2f(Vector2f other) {
        this.x = other.x;
        this.y = other.y;
    }
    
    //accessors
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }    
    
    //mutators
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void addX(float x){
    	this.x += x;
    }
    public void addY(float y){
    	this.y += y;
    }
    
    /**
     * an equals method to see if two vectors are equal
     */
    public boolean equals(Vector2f other) {
        return this.x == other.x && this.y == other.y;
    }
    
    /**
     * gets the magnitude of the vector
     */
    public float magnitude() {
        return (float)Math.hypot(x, y);
    }
    
    /**
     * gets the angle of the vector
     */
    public float angle() {
        return (float)Math.atan2(y, x);
    }
    
    /**
     * to implement an add-equal effect
     */
    public void addEquals(Vector2f other) {
        this.x += other.x;
        this.y += other.y;
    }
    
    /**
     * returns a new vector that is the sum of the implicit and explicit vector
     */
    public Vector2f add(Vector2f other) {
        return new Vector2f(this.x + other.x, this.y + other.y);
    }
    
    /**
     * returns a copy of the vector negated
     */
    public Vector2f negated() {
        return new Vector2f(-this.x, -this.y);
    }
    
    /**
     * negates the current vector
     */
    public void negate() {
        this.x *= -1;
        this.y *= -1;
    }
    
    /**
     * returns a copy of the implicit vector scaled up by an amount
     */
    public Vector2f scaled(float amount) {
        return new Vector2f(this.x * amount, this.y * amount);
    }
    
    /**
     * scales the implicit vector without returning a copy
     */
    public void scale(float amount) {
        this.x *= amount;
        this.y *= amount;
    }
    
    /**
     * returns a human-readable representation of the vector
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    /**
     * just returns a new copy of the zero vector
     */
    //making zero a method instead of a constant prevents changing the fields
    public static Vector2f zero() {
        return new Vector2f(0, 0);
    }
}