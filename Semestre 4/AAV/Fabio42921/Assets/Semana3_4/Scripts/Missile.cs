using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Missile : MonoBehaviour
{
    private float bulletSpeed;

    private void Start() {
        bulletSpeed = 5;
        StartCoroutine(DestroyMissile());
    }

    // Update is called once per frame
    void Update()
    {
        transform.Translate(Vector3.forward * bulletSpeed * Time.deltaTime);
    }

    private IEnumerator DestroyMissile()
    {
        yield return new WaitForSeconds(5);
        Destroy(gameObject);
    }

    private void OnCollisionEnter(Collision other) {
        
        Destroy(other.gameObject);
        Destroy(gameObject);
    }
}