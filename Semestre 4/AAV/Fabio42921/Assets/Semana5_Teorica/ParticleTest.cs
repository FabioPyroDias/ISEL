using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ParticleTest : MonoBehaviour
{
    private ParticleSystem particleSystem;

    // Start is called before the first frame update
    void Start()
    {
        particleSystem = GetComponent<ParticleSystem>();
        particleSystem.Play();
    }

    // Update is called once per frame
    void Update()
    {
        ParticleSystem.EmissionModule em = particleSystem.emission;
        em.enabled = Input.GetKey(KeyCode.K);

        /*
        if(Input.GetKeyUp(KeyCode.K))
        {
            particleSystem.Play();
        }

        if(Input.GetKeyUp(KeyCode.L))
        {
            particleSystem.Stop();
        }

        if(Input.GetKeyUp(KeyCode.J))
        {
            particleSystem.Clear();
        }
        */
    }
}