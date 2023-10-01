using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EvilCube : MonoBehaviour, Hittable
{
    public void GetHit()
    {
        GetComponent<Renderer>().material.color = new Color(Random.value, Random.value, Random.value);
    }
}
