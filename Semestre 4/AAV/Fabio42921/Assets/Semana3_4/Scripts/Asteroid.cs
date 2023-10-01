using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Asteroid : MonoBehaviour
{
    private float movementSpeed;

    // Start is called before the first frame update
    void Start()
    {
        movementSpeed = Random.Range(2, 10);
    }

    // Update is called once per frame
    void Update()
    {
        transform.Translate(-Vector3.forward * movementSpeed * Time.deltaTime);
    
        DestroyAsteroid();
    }

    private void DestroyAsteroid()
    {
        if(transform.position.z < -5)
        {
            Destroy(gameObject);
        }
    }
}
