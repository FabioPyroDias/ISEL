using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    public float bulletSpeed = 0.0f;
    public float bulletLifeSpan = 2.0f;

    // Start is called before the first frame update
    void Start()
    {
        StartCoroutine(DestroyRoutine());
    }

    // Update is called once per frame
    void Update()
    {
        transform.Translate(transform.forward * bulletSpeed * Time.deltaTime, Space.World);
    }

    IEnumerator DestroyRoutine()
    {
        yield return new WaitForSeconds(bulletLifeSpan);
        Destroy(gameObject);
    }

    private void OnCollisionEnter(Collision other)
    {
        Destroy(other.gameObject);
        Destroy(gameObject);
    }
}