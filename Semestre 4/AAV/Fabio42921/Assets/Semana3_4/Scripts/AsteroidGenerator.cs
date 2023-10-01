using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AsteroidGenerator : MonoBehaviour
{
    [SerializeField] private Transform ship;
    [SerializeField] private GameObject asteroidPrefab;
    [SerializeField] private float asteroidSpawnCooldown;

    [SerializeField] private float spawnOffset;

    private bool canSpawn;

    // Start is called before the first frame update
    void Start()
    {
        StartCoroutine(SpawnCooldown());
    }

    // Update is called once per frame
    void Update()
    {
        SpawnAsteroid();
    }

    private void SpawnAsteroid()
    {
        if(canSpawn && ship != null)
        {
            Vector3 spawnPosition = new Vector3(Random.Range(-8, 8), 0, transform.position.z);
            Instantiate(asteroidPrefab, spawnPosition, transform.rotation);
            StartCoroutine(SpawnCooldown());
        }
    }

    private IEnumerator SpawnCooldown()
    {
        canSpawn = false;
        yield return new WaitForSeconds(asteroidSpawnCooldown);
        canSpawn = true;
    }
}
