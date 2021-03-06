package com.pillarmen.utils;

import com.pillarmen.entity.GameObject;
import com.pillarmen.math.AABB;

public class GameObjectKey {

    public float value;
    public GameObject go;

    public GameObjectKey(float value, GameObject go) {
        this.value = value;
        this.go = go;
    }

    public AABB getBounds() { return go.getBounds(); }
}