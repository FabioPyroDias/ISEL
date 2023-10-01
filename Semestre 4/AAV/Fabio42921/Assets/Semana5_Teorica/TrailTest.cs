using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TrailTest : MonoBehaviour
{
    private TrailRenderer trail;
    private Camera cam;
    [SerializeField] private float offset;
    // Start is called before the first frame update
    void Start()
    {
        trail = GetComponent<TrailRenderer>();
        cam = Camera.main;

        trail.emitting = false;
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetButton("Fire1"))
        {
            trail.emitting = true;

            Ray ray = cam.ScreenPointToRay(Input.mousePosition);
            transform.position = ray.origin + ray.direction * offset;
        }
        else
        {
            trail.emitting = false;
            trail.Clear();
        }
    }
}