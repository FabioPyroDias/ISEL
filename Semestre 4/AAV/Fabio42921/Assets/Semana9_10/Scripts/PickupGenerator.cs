using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PickupGenerator : MonoBehaviour
{

    private const float PickupCreationIntervalMin = 5;
    private const float PickupCreationIntervalMax = 60;

    public Pickup prefab;

    void Start()
    {
        CreateNewPickup();
    }

    public void CreateNewPickup()
    {
        StartCoroutine(CreateNewPickupRoutine());
    }

    IEnumerator CreateNewPickupRoutine()
    {
        yield return new WaitForSeconds(Random.Range(PickupCreationIntervalMin, PickupCreationIntervalMax));

        CreatePickup();
    }

    public void CreatePickup()
    {

        Pickup pickup = Instantiate<Pickup>(prefab, transform.position, Quaternion.identity);

        pickup.SetGenerator(this);

    }

    
}
